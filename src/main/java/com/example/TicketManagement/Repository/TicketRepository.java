package com.example.TicketManagement.Repository;

import com.example.TicketManagement.model.TicketEntity;
import com.example.TicketManagement.projection.TicketListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    @Query(value = """
        SELECT
            t.ticket_id   AS ticketId,
            t.title       AS title,
            t.status      AS status,
            t.priority    AS priority,
            t.created_on  AS createdOn
        FROM ticket t
        WHERE t.is_deleted = 0
                AND (:search ='' OR t.title ILIKE CONCAT('%', :search, '%'))
                AND (:status = '' OR t.status = :status)
                AND (:priority = '' OR t.priority = :priority)
        ORDER BY 
                    CASE WHEN :sortOrder = 'asc' AND :sortBy  = 'priority' THEN t.priority END ASC,
                    CASE WHEN :sortOrder = 'desc' AND :sortBy = 'priority' THEN t.priority END DESC,
                            
                    CASE WHEN :sortOrder = 'asc' AND :sortBy = 'status' THEN t.status END ASC,
                    CASE WHEN :sortOrder = 'desc' AND :sortBy = 'status' THEN t.status END DESC,
                            
                    CASE WHEN :sortOrder = 'asc' AND :sortBy = 'createdOn' THEN t.created_on END ASC,
                    CASE WHEN :sortOrder = 'desc' AND :sortBy = 'createdOn' THEN t.created_on END DESC,
                            
                    t.ticket_id DESC
        LIMIT :limit OFFSET :offset
        """,
            nativeQuery = true)
    List<TicketListProjection> findTickets(
            @Param("limit") int limit,
            @Param("offset") int offset,
            @Param("search") String search,
            @Param("status") String status,
            @Param("priority") String priority,
            @Param("sortBy") String sortBy,
            @Param("sortOrder") String sortOrder
    );



    @Query(value = """
        SELECT COUNT(*)
        FROM ticket t
        WHERE t.is_deleted = 0
                AND (:search = '' OR t.title ILIKE CONCAT('%', :search, '%'))
                AND (:status = '' OR t.status = :status)
                AND (:priority = '' OR t.priority = :priority)
        """,
            nativeQuery = true)
    long countTickets(
            @Param("search") String search,
            @Param("status") String status,
            @Param("priority") String priority
    );

    @Query(value = """
        SELECT DISTINCT status from ticket;
""", nativeQuery = true)
    List<String> statusList();


}

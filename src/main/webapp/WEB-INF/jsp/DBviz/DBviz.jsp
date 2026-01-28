<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Database Schema Visualization</title>
    <script src="https://cdn.jsdelivr.net/npm/mermaid@10.9.0/dist/mermaid.min.js"></script>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 { color: #333; margin-bottom: 10px; }
        .info {
            background: #fff; padding: 10px 20px; border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1); margin-bottom: 20px;
            text-align: center; font-size: 0.9em; color: #666;
        }
        .diagram-container {
            background-color: white; padding: 20px; border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            width: 100%; max-width: 1400px; overflow: auto;
        }
    </style>
</head>
<body>

<h2>Database Schema Visualization</h2>

<div class="info">
    <strong>Tip:</strong> Diagram is rendered in standard monochrome to prevent syntax errors.
</div>

<div class="diagram-container">
        <pre class="mermaid">
erDiagram
    user_front ||--o{ user_role_new : has_role
    user_role ||--o{ user_role_new : assigned_to
    user_front ||--o{ company_setting : configures
    user_front ||--o{ document : owns
    user_front ||--o{ feedback : submits

    user_front ||--o{ ticket : creates
    ticket ||--o{ ticket_attachment : contains
    ticket ||--o{ comments : has
    ticket ||--o{ notes : internal_notes
    ticket ||--o{ status_history : tracks
    ticket ||--o{ ticket_approval : needs_approval
    ticket ||--o{ reject_history : rejections

    comments ||--o{ comments_attachment : files
    notes ||--o{ notes_attachment : files

    type_master ||--o{ ticket : classifies

    nav_menu ||--o{ nav_sub_menu : parent_of
    nav_menu ||--o{ nav_menu_permission : controls
    user_role ||--o{ nav_menu_permission : access
    nav_sub_menu ||--o{ nav_menu_action : triggers

    user_front ||--o{ notification_master : receives
    user_front ||--o{ one_signal : device_token
        </pre>
</div>

<script>
    // Initialize Mermaid
    mermaid.initialize({
        startOnLoad: true,
        theme: 'default',
        securityLevel: 'loose'
    });
</script>
</body>
</html>
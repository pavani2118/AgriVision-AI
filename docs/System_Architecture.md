# System Architecture

## Overview

AgriVision AI follows a microservice-based architecture consisting of a React frontend, a Spring Boot backend, and a FastAPI AI service.

## Architecture Diagram

```text
                React Frontend
                      |
                      |
              Spring Boot Backend
                      |
        -----------------------------
        |                           |
 PostgreSQL Database          FastAPI AI Service
                                      |
                                TensorFlow Model
                                      |
                                   OpenCV
```

## Components

### Frontend
- React
- Responsive UI
- Image upload
- Dashboard
- Authentication

### Backend
- Spring Boot
- REST APIs
- JWT Authentication
- Business Logic

### Database
- PostgreSQL
- Stores users, farms, diseases, and predictions

### AI Service
- FastAPI
- TensorFlow CNN Model
- OpenCV Image Processing

## Future Enhancements

- Docker
- GitHub Actions
- AWS Deployment
- Prometheus
- Grafana
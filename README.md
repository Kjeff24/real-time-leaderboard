# Real-Time Leaderboard Service

## Overview
This project involves creating a backend system for a real-time leaderboard service. The service allows users to compete in various games or activities, track their scores, and view their rankings on a leaderboard. The system features user authentication, score submission, real-time leaderboard updates, and score history tracking.

## Features
- **User Authentication**: Users can register and log in securely.
- **Score Submission**: Users can submit their scores for different games or activities.
- **Leaderboard Updates**: Displays a global leaderboard showing the top users across all games.
- **User Rankings**: Allows users to view their ranking on the leaderboard.
- **Top Players Report**: Generates reports on the top players for a specific period.

## Tech Stack
- **Backend**: Spring Boot (Java) or Node.js (Express.js)
- **Database**: PostgreSQL / MySQL (User authentication and history tracking)
- **Cache**: Redis (Leaderboard management)
- **Authentication**: JWT (JSON Web Tokens)

## Installation
### Prerequisites
- Java 21+
- PostgreSQL / MySQL
- Redis

### Setup
1. **Clone the Repository**
   ```sh
   git clone https://github.com/Kjeff24/real-time-leaderboard.git
   cd real-time-leaderboard
   ```
   2. **Configure the Environment**
   - Create a `.env` file with database and Redis configurations, example:
     ```env
     SECRET_KEY=BJcBl5N8R8DiOxLePasxb90OYxPERfa1UMoY3bxohNw=
     REDIS_HOST=localhost
     REDIS_PORT=6379
     REDIS_PASSWORD=password
     DB_URL=jdbc:postgresql://localhost:5432/leaderboard
     DB_USERNAME=postgres
     DB_PASSWORD=postgres
     ```
3. **Install Dependencies**
    - For Java (Spring Boot):
      ```sh
      mvn clean install
      ```
4. **Run the Application**
    - Spring Boot:
      ```sh
      mvn spring-boot:run
      ```

## API Endpoints
### Authentication
- **Register**: `POST /api/v1/auth/signup`
- **Login**: `POST /api/v1/auth/login`


## Contributing
1. Fork the repository.
2. Create a new branch (`feat/your-feature`).
3. Commit your changes.
4. Push to the branch and create a Pull Request.



# Account Management API

This is a simple RESTful social media API for managing user accounts, following and unfollowing of accounts, as well as retrieval of posts based on accounts you are following.

## Features

- **Create Account**: Add a new user account with details such as username, password, and email.
- **Get Account by ID**: Retrieve details of a specific account using its unique ID.
- **Get All Accounts**: Retrieve a list of all user accounts in the system.
- **Follow an account** Follows an account based on followerId and followedId
- **Unfollow an account** Unfollows an account based on followerId and followedId
- **Retrieve followers** retrieves all the followers of an account based on accountId
- **Retrieve following** retrieves all the following of an account based on accountId
## Technologies Used

- **Spring Boot**: Backend framework for building the API.
- **Hibernate**: ORM (Object-Relational Mapping) for database interactions.
- **Lombok**: Library for reducing boilerplate code (e.g., getters, setters).
- **MySQL/PostgreSQL**: Database for storing account information (not included in the code but assumed to be used).

## API Endpoints

### 1. Create Account
- **Endpoint**: `POST /api/account`
- **Request Body**:
  ```json
  {
    "username": "john_doe",
    "password": "securepassword",
    "email": "john.doe@example.com"
  }

### 2. Retrieve Account by id
- **Endpoint**: `GET /api/account?accountId=1`

### 3. Retrieve All accounts
- **Endpoint**: `GET /api/account/getAll`

### 4. Follow an account
- **Endpoint**: `GET /api/account/follow?followedId=12&followerId=11`

### 5. Retrieve followers
- **Endpoint**: `GET api/account/follower?accountId=11`

### 6. Retrieve following
- **Endpoint**: `GET api/account/following?accountId=11`
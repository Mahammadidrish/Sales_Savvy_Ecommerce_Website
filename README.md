**SalesSavvy - E-commerce Platform 🛒**
SalesSavvy is a modern e-commerce web application that allows users to browse products, add items to their cart, place orders, and make secure payments. The application follows a React.js frontend and Spring Boot backend architecture.

**📌 Tech Stack**
Frontend (Client)
React.js (JSX)
React Router for navigation
Backend (Server)
Spring Boot (Java)
Spring Security (JWT Authentication)
Spring Data JPA for database interaction
MySQL for data storage
Razorpay API for payments
Spring Mail for email notifications

**📂 Project Structure**
SalesSavvy/
│── SS-FE/                   # Frontend (React.js)
│   ├── src/
│   ├── public/
│   ├── package.json
│   ├── vite.config.js
│   ├── README.md
│── SS-BE/                   # Backend (Spring Boot)
│   ├── src/main/java/
│   ├── src/main/resources/
│   ├── pom.xml
│   ├── README.md
│── docker-compose.yml
│── .gitignore
│── README.md

**🚀 Getting Started
🛠 Prerequisites**
Before running the project, install the following:
Node.js (for frontend)
Java 17+ (for backend)
MySQL (Database)
Docker (Optional)
📦 Backend Setup

1️⃣ Clone the Repository
git clone https://github.com/Mahammadidrish/Sales_Savvy_Ecommerce_Website.git
cd SalesSavvy/SS-BE

2️⃣ Set Up MySQL Database
CREATE DATABASE sales_savvy;
Configure database credentials in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/sales_savvy
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

3️⃣ Run the Backend
mvn clean install
mvn spring-boot:run
✅ Backend will start on: http://localhost:9090

🎨 Frontend Setup
1️⃣ Navigate to Frontend Directory
cd SalesSavvy/SS-FE
2️⃣ Install Dependencies
npm install
3️⃣ Run the Frontend
npm run dev
✅ Frontend will start on: http://localhost:5174

**🔗 API Endpoints**
Authentication
POST /api/auth/register → User Registration
POST /api/auth/login → User Login
POST /api/auth/logout → Logout User
Products
GET /api/products → Fetch all products
GET /api/products/{id} → Get product by ID
POST /api/products → Add new product (Admin only)
Cart
POST /api/cart/add → Add item to cart
GET /api/cart → View cart items
Orders
POST /api/orders → Place an order
GET /api/orders/{userId} → Get user orders

🐳 Running with Docker
1️⃣ Build and Run with Docker Compose
docker-compose up --build
2️⃣ Stop the Containers
docker-compose down

📜 Git Workflow
🚀 First-Time Setup
git init
git remote add origin https://github.com/Mahammadidrish/Sales_Savvy_Ecommerce_Website.git
git branch -M main
git pull origin main
🌟 Push New Changes
git add .
git commit -m "Your commit message"
git push origin main

⬇️ Fetch Latest Changes
git pull origin main
📢 Contributing
🚀 Contributions are welcome! If you'd like to contribute:

Fork the repository
Create a new branch (git checkout -b feature-branch)
Commit changes (git commit -m "Added new feature")
Push to your branch (git push origin feature-branch)
Open a Pull Request
📞 Contact : 9652869106
For any issues or queries, feel free to reach out: 📧 Email: [mahammadidrishd965@gmail.com]
🌐 GitHub: [https://github.com/Mahammadidrish]

🎉 Happy Coding! 🚀



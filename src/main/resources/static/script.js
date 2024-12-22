// Constants for API endpoints
const BASE_URL = "http://localhost:9098"; // Base URL for your backend

// Fetch and display job vacancies
document.addEventListener("DOMContentLoaded", async () => {
    const jobList = document.getElementById("job-list");

    if (jobList) {
        try {
            const response = await axios.get(`${BASE_URL}/vacancies`);
            const jobs = response.data;

            if (jobs.length === 0) {
                jobList.innerHTML = '<p class="text-gray-400">No jobs available at the moment.</p>';
            } else {
                jobList.innerHTML = jobs
                    .map(
                        (job) => `
                    <div class="bg-gray-900 p-6 rounded shadow-lg hover:shadow-xl">
                        <h3 class="text-xl font-bold text-green-400">${job.title}</h3>
                        <p class="text-gray-300 mt-2">${job.description}</p>
                        <p class="text-gray-400 mt-2">Location: ${job.location}</p>
                        <p class="text-gray-400 mt-2">Salary: $${job.salary}</p>
                    </div>`
                    )
                    .join("");
            }
        } catch (error) {
            jobList.innerHTML =
                '<p class="text-red-400">Failed to load jobs. Please try again later.</p>';
            console.error("Error fetching job vacancies:", error);
        }
    }
});

// Handle user login form
document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("login-form");
    const profileContent = document.getElementById("profile-content");

    if (loginForm) {
        loginForm.addEventListener("submit", async (event) => {
            event.preventDefault(); // Prevent form from reloading the page

            const username = document.getElementById("username").value.trim();
            const password = document.getElementById("password").value.trim();

            if (!username || !password) {
                alert("Please enter both username and password.");
                return;
            }

            try {
                const response = await axios.post(`${BASE_URL}/login`, {
                    username,
                    password,
                });

                const user = response.data;

                if (user && user.name) {
                    // Update the profile content with user data
                    profileContent.innerHTML = `
                        <h3 class="text-xl font-bold text-green-400">Welcome, ${user.name}</h3>
                        <p class="text-gray-300 mt-2">Email: ${user.email}</p>
                        <p class="text-gray-300 mt-2">Role: ${user.role}</p>
                    `;
                    profileContent.classList.remove("hidden");
                    loginForm.classList.add("hidden");
                } else {
                    alert("Invalid response from server.");
                }
            } catch (error) {
                alert("Login failed. Please check your username and password.");
                console.error("Error during login:", error);
            }
        });
    }
});

### Project Structure

```
deniz_yavuz_case_project
│
├─ insider-ui-tests → Selenium UI automation
├─ petstore-api-tests → REST API automation tests
├─ performance_test → Locust performance testing
└─ report → Test reports
```

### 1. UI Test Automation

Automation of Insider QA career flow using Java + Selenium + JUnit 5 with Page Object Model.

## Scenario

The automated test performs the following steps:

Visit https://insiderone.com/

Verify the homepage is opened and main blocks are loaded

Navigate to Careers page

Click See all QA jobs

Filter jobs by:

Location → Istanbul

Department → Quality Assurance

Validate that all jobs match the filter criteria

Click View Role

Verify redirection to Lever Application form page

Validate the presence of the application form

## Technologies

Java

Selenium WebDriver

JUnit 5

Maven

Page Object Model

## Run UI Tests

```
cd insider-ui-tests
mvn clean test
```

### 2. API Test Automation

API tests implemented using Java + RestAssured + JUnit against the Swagger Petstore API.

## Tested Endpoints

```
POST /pet → Create pet
GET /pet/{id} → Retrieve pet
PUT /pet → Update pet
DELETE /pet/{id} → Delete pet
```

## Test Scenarios

Create pet (Happy path)

Create pet with invalid ID

Read existing pet

Read non-existing pet

Validate response status codes

Validate API response body

## Technologies

Java

RestAssured

JUnit 5

Maven

## Run API Tests

```
cd petstore-api-tests

mvn clean test
```

### 3. Performance Testing

Performance testing implemented using Locust (Python).

## Tested Components

Autocomplete Service

Search Results Page

## Tools

Python

Locust

## Performance Test Structure

```
performance_test
│
├─ locust
│ └─ locustfile.py
│
└─ data
  └─ keywords
```

## Run Performance Tests

Install Locust

```
pip install locust
locust -f locust/locustfile.py --host https://www.n11.com
```

Then open:

```
http://localhost:8089
```

## Test Reports

Test reports are stored in the report directory.

```
report/
```

The project follows good testing practices:

- Page Object Model (UI tests)
- Reusable API client
- Modular test architecture
- Parameterized test flows
- Failure screenshot capture
- Clean project structure

### Author

Deniz Yavuz - QA Engineer - Assessment Project

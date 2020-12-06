@insiderTest
Feature: Test task

  Scenario: Apply for Insider job
#  1. Visit https://useinsider.com/ and check Insider home page is opened or not
    Given Open insider page
#  2. Select “Career” menu in navigation bar and check Career page, its Culture, Locations, Teams, Jobs and Life at Insider blocks are opened or not
    When Click in header 'CAREER' button
    When Insider career check menu head contains
      | CULTURE         |
      | LOCATIONS       |
      | TEAMS           |
      | JOBS            |
      | LIFE AT INSIDER |
    Then Insider career check that culture block is visible
    Then Insider career check that locations block is visible
    Then Insider career check that teams block is visible
    Then Insider career check that jobs block is visible
    Then Insider career check that life at insider block is visible
#  3. Scroll to Career Opportunities, filter jobs by Location - Istanbul, Turkey and department - Quality Assurance, check presence of jobs list
    When Insider career scroll to the Career Opportunities block
    When Insider career career opportunities choose office filter 'Istanbul, Turkey'
    When Insider career career opportunities choose department filter 'Quality Assurance'
    Then Insider career career opportunities check the presence of jobs list
#  4. Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, Location contains “Istanbul, Turkey”
    Then Insider career career opportunities check that all jobs department is 'Quality Assurance'
    Then Insider career career opportunities check that all jobs location is 'Istanbul, Turkey'
#  5. Select one of the positions, check that correct position page is opened, presence of job description, requirements and “Apply for this job” button
    When Insider career career opportunities click job title 'Quality Assurance Team Lead'
    Then Insider career check job title is 'Quality Assurance Team Lead'
    Then Insider career check job description block is presence
    Then Insider career check that apply for this job btn is shown
#  6. Click “Apply for this job” button and check that this action redirects us to Application form page
    When Insider career job page click headline apply for this job btn
    Then Insider career check job page application form is opened

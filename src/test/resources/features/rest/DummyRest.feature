Feature: DemoApi

  Scenario:  Perform CREATE, GET and DELETE on DummyRestApi

    * [REST] Retrieve all employees
    * [REST] Retrieve all employee and verify request is Successfully and counts the number of employees over 30
    * [REST] Add new employee {\"name\":\"Adina\",\"salary\":\"150150\",\"age\":\"28\"} and verify that request returns code 200
    * [REST] Delete employee id 20 and verify that request has status is success and status code 200
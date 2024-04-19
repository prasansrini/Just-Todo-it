# Just Todo it!

### Introduction:

A simple Spring boot back-end application to serve and maintain Todo list and users using the application.

### Endpoints:
* /register - Registration of a user into the portal.
  * POST - Takes in registration information.
* /login - User login to the portal.
  * POST - Takes in login details. 
* /create - Create a Todo with all the required details.
  * POST - Takes in Todo information to be created.
* /list/{userId} - List Todo for the given user.
  * GET - To fetch the list of tasks for a given user.
* /list/open - List of open items in the Todo list.
  * GET - To fetch the list of open tasks for a given user.
* /list/done - List of closed items in the Todo list.
  * GET - To fetch the list of closed tasks for a given user.

### Procedure to run:
* Set up the DB with the correct configuration.
* Update DB URL in the application.properties.
* Run ./build_install.sh <db_username> <db_password>

### Running tests:
* Run ./build_test.sh adn verify if all the tests are passing.

### Contributors:
* **Prasanna Srinivasan**
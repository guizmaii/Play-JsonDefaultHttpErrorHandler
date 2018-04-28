# PlayScala-JsonDefaultHttpErrorHandler

Play Scala `JsonDefaultHttpErrorHandler` test project.

## Instructions to test the new `JsonDefaultHttpErrorHandler`

1. Publish a local version of Play   
    1.1 `$ git clone https://github.com/guizmaii/playframework`   
    1.2 `$ cd playframework`   
    1.3 `$ git checkout json_default_http_error_handler`   
    1.4 `$ sbt clean publishLocal`   

2. (If necessary) Change the version of Play in `project/plugins.sbt` with the previously locally published one.

3. `$ sbt run`   

4. Test with diffent calls   
    4.1 (HTTP 200) `$ curl -v http://localhost:9000/ | python -m json.tool`   
    4.2 (HTTP 404) `$ curl -v http://localhost:9000/routeThatDoesNotExist | python -m json.tool`  
    4.3 (HTTP 500) `$ curl -v http://localhost:9000/exception | python -m json.tool`   
    
(The `| python -m json.tool` part of the command is here to pretty print JSON answers. Comes from here: https://stackoverflow.com/a/1920585)
##### Swagger url:
http://localhost:8080/swagger-ui.html#/ 
* Create API:

<br>1. 200,Ok
<br> Request
 ```bash
curl --location 'http://localhost:8080/users/createUsers' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--data '{
    "id": "125",
    "name": "Ashish"
}'
```
<br> Response

````json
{
    "name": "Ashish",
    "id": "125"
}
````

<br>2. Bad Request
<br> Request
 ```bash
curl --location 'http://localhost:8080/users/createUsers' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--data '{
    "id": "1255555",
    "name": "Ashish"
}'
```

<br> Response

````json
[
  {
    "code": "ERR001",
    "message": "userId must be alphanumeric, maximum 5 characters."
  }
]
````

## Validations:

```
ERR001("Invalid userId", "userId must be alphanumeric, maximum 5 characters.", false, "^[0-9A-Za-z]{1,5}$", HttpStatus.ACCEPTED),
ERR002("Invalid name", "Name must be alphanumeric, maximum 10 characters.", false, "^[0-9A-Za-z]{1,10}$", HttpStatus.ACCEPTED);
```

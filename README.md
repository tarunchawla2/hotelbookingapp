# Hotel Booking App

## Steps to run
1. Assuming you have docker and docker-compose installed, simply run
    ```
    mvn clean install -DskipTests
    ```
    ```
    sudo docker-compose up
    ```
    The application will be running on port 80. 
    **_Note:_** If you don't want to run it using docker or if you want to run it locally in your IDE then, then before running it, make changes in application properties for your database URL.
1. ## List  of Apis
    ## Model- Hotel
    #### Adding Hotel
    ```
      URL -> http://<ip_address>/hotel/add, method=POST
    ```
    Request Body
    ```   
      {
        "name":"Taj",
        "city":"Gurgaon",
        "noOfRooms":3,
        "star":"3",
        "room":[
          {
          "roomNo":101,
          "beds":3,
          "bookingDate":"2020-05-01"
        }
        ,{
          "roomNo":102,
          "beds":2
        },
        {
          "roomNo":103,
          "beds":2
        }
        ],
        "facilities":{
          "wifiAvailability":"yes",
          "restaurantAvailability":"yes",
          "airConditioningAvailability":"yes",
          "mealsIncluded":"no"
        },
        "user":[]
      }
    ```
    
    ### Getting all hotels
    ```
    Url-> http://<ip_address>/hotel/all, method=GET, 
    ```
    
    ### Updating a hotel
    ```
    Url-> http://ip_address/hotel/update/{id}, methods=PUT
    ```
    Request Body
    ```
    {
      "name":"Taj",
      "city":"Mumbai",
      "noOfRooms":10,
      "stars":5
    }
    ``` 
    ### Search a hotel
    ```
    URL-> http://<ip_address>/hotel/search, method=POST
    ```
    ```
    Request Body
      {
        "city":"Gurgaon",
        "noOfRooms":2,
        "dateOfCheckIn":"2020-06-01",
        "star":"3",
        "mealsIncluded":"no",
        "wifiAvailability":"yes"
      }
    ```
    ### Delete a hotel
    ```
    URL-> http://<ip_address>/hotel/delete/{id}, method=DELETE
    ```
    
    ## Model- User
    ### Adding a user
    ```
    Url-> http://<ip_address>/user/add, method=POST
    ```
    Request Body
    ```
    {
	    "firstName":"tarun",
	    "lastName":"chawla"
    }
    ```
    ### Update a User
    ```
    Url->http://<ip_address>/user/update/{id}, method=PUT
    ```
    Request Body
    ```
    {
	    "firstName":"tarun",
	    "lastName":"goel"
    }
    ```
    ### Get all user
    ```
    Url-> http://<ip_addres>/user/all, method=GET
    ```
    
    ## Model- Review
    ### Post a review
    ```
    URL-> http://<ip_address>/review/{userId}/{hotelId}, method=POST
    ```
    Request Body
    ```
    {
	    "rating":"6",
	    "comment":"Nice Service"
    }
    ```




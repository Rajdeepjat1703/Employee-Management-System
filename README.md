[Employee Management System.postman_collection.json](https://github.com/user-attachments/files/18758819/Employee.Management.System.postman_collection.json)[Uploadi{
	"info": {
		"_postman_id": "d13b657d-f94f-4cc6-a046-58e5163c09e2",
		"name": "Employee Management System",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "33329301"
	},
	"item": [
		{
			"name": "AddEmployee",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Fetch Employee by ID",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Update the Employee",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Delete the Employee",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Add Skill to Employee",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \"id\": 1,\r\n        \"name\": \"Rajdeep Jat\",\r\n        \"email\": \"rajdeep@example.com\",\r\n        \"role\": \"Software Engineer\",\r\n        \"department\": \"Engineering\",\r\n        \"skills\": [ {\r\n      \"id\": 1,\r\n      \"name\": \"Java\"\r\n    }],\r\n        \"projects\": []\r\n    }",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8092/1/skills/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8092",
					"path": [
						"1",
						"skills",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Add Skills",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Add project",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Assign Project to Employee",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		}
	]
}ng Employee Management System.postman_collection.json…]()


Redish performed-
![image](https://github.com/user-attachments/assets/d743e411-7c3b-4033-8112-91afa84c835d)
this is my redis cache which have Employee Cache

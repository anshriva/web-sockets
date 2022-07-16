# Websockets

- Websockets are helpful when there is frequent two-way communication between services & latency is extremely important.  
- Examples: chatting application , gaming.  
- Under the hood it runs on TCP. It does not support UDP. 
- The advantage is that ones a connection is built, it does not get closed unless closed specifically or timeout occurred for idle connection.

### web-socket client
The client code is available in many languages like Java, java-script.\
Websocket client can be created using browser without using any library. \
For this project we are using java-script. 

```js
// connecting to websocket server
let ws = new WebSocket('ws://localhost:8080/user');

// getting data from server.
ws.onmessage = message => {
    console.log(message.data);
}
// sending data to server
ws.send('hello');
```

### web-socket server

The server can be written in any server side language like java, node.js etc. \
For this demo we are using java spring framework. 


## Data-flow

If two people are chatting with each other, then the connection will be from both the browsers to server. 
The chat message will be sent to the server and there-after the server will send the data to other participant. 


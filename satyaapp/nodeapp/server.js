//getting the dependencies of the standard express module
import express from 'express';

//importing the file system module
import fs from 'fs';

//Initializing an app  - this is a server side app
const app = express();

//Start serving the whole folder using my web server
app.use(express.static('webapp'));

//Registering the end point
app.get('/', (req, res) => {
  res.send('Hello World');
});

//In my server now I am adding one more end point to return employee data
app.get('/employees', (req, res) => {
    var contentFile = fs.readFileSync("./webapp/emp.json", "utf-8");
    res.send(contentFile);
});

//Listen to a port to start the web app
app.listen(process.env.PORT || 4000, () => {
  console.log('Server is running on http://localhost:4000');
});

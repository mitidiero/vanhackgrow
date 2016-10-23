var app, server,
    express = require('express'),
    path = require('path'),
    host = process.env.HOST || '127.0.0.1',
    port = parseInt(process.env.PORT) || 3000,
    pub = path.join(__dirname, 'public'),
    dist = path.join(__dirname, 'deploy');

app = express();
app.use(function(req, res, next) {
    console.log(req.url); next();
});
app.use(express.static(pub));
app.use('/dist', express.static(dist));
server = app.listen(port, host, serverStarted);

function serverStarted () {
    console.log('Server started at http://%s:%s', host, port);
    console.log('Press Ctrl+C to stop...\n');
}
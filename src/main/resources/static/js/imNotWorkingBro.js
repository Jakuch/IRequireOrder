function pleaseTakeMeFromHere() {
    var arrayOfEndpoints = ["/home", "/heroes", "/initiativeTracker", "/heroesAll", "/heroesAdd", "/levelsTable"];

    var randomEndpoint = arrayOfEndpoints[Math.floor(Math.random() * arrayOfEndpoints.length)];

    var random = "http://localhost:8080"+randomEndpoint

    window.location.replace(random);
}
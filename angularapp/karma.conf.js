const customWebDriver = require('./webdriver-config'); // Adjust the path as needed

// module.exports = function(config) {
//   config.set({
//     // ...
//     browsers: ['CustomWebDriver'],
//     customLaunchers: {
//       CustomWebDriver: {
//         base: 'WebDriver',
//         browser: customWebDriver,
//         logLevel: config.LOG_DEBUG
//       },
//     },
//     // ...
//   });
// };
module.exports = function(config) {
  config.set({
    webdriver: {
      // Change this URL to the appropriate Selenium server URL
      serverUrl: 'http://localhost:4444/wd/hub'
    }
  });
};



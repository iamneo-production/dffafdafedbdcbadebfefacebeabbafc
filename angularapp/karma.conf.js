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
    browsers: ['RemoteChrome'],
    customLaunchers: {
      RemoteChrome: {
        base: 'WebDriver',
        browserName: 'chrome',
        name: 'Karma',
        config: {
          hostname: 'localhost',
          port: 4444
        }
      }
    }
  });
};



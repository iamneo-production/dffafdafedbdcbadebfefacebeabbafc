const customWebDriver = require('./webdriver-config'); // Adjust the path as needed

module.exports = function(config) {
  config.set({
    // ...
    browsers: ['CustomWebDriver'],
    customLaunchers: {
      CustomWebDriver: {
        base: 'WebDriver',
        browser: customWebDriver
      },
    },
    // ...
  });
};

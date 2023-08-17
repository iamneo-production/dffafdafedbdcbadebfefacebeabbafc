module.exports = function(config) {
  config.set({
    port:
    // ...
    browsers: ['Selenium_Chrome'], // Use the name of the browser launcher
    customLaunchers: {
      Selenium_Chrome: {
        base: 'WebDriver',
        browserName: 'chrome',
        config: {
          // Specify the WebDriver options here
          // Example: chromeOptions: { args: ['--headless'] }
        },
      },
    },
    // ...
  });
};

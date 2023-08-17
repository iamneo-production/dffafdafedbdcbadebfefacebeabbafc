const webdriver = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');

// Configure Chrome options
const chromeOptions = new chrome.Options();
// Add any desired options, e.g., chromeOptions.addArguments('--headless');

// Set the desired IP address and port for the WebDriver
const driver = new webdriver.Builder()
  .forBrowser('chrome')
  .setChromeOptions(chromeOptions)
  .usingServer('http://34.85.201.58:4841/wd/hub') // Replace <your-ip> with the actual IP
  .build();

module.exports = driver;

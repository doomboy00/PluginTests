function spoof() {
}

spoof.prototype.spoof = function (callback) {
  cordova.exec(callback, function(err) { alert('Error'); }, "spoof", "spoof", []);
};

spoof.prototype.listAdd = function(callback) {
	condova.exec(callback, function(err){ alert('Error getting list'); }, 'spoof', 'listAdd', []);	
}

spoof.prototype.getMac = function(callback) {
	cordova.exec(callback, function(err){ alert('Error getting MAC'); }, 'spoof', 'getMac', []);	
}

spoof.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.spoof = new spoof();
  return window.plugins.spoof;
};

cordova.addConstructor(spoof.install);
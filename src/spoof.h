#import <Cordova/CDV.h>

@interface spoof : CDVPlugin

- (void)getMac:(CDVInvokedUrlCommand*)command;
- (void)listAdd:(CDVInvokedUrlCommand*)command;
- (void)spoof:(CDVInvokedUrlCommand*)command;

@end

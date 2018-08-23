# auditd_for_android
This project aims to make the audit subsystem of the Linux Kernel usable for Android 6+.
It does so by porting auditd and its userland tools to Androids by forking and making Android-NDK projects out of them.

Since the administration of auditd is usually only possible via the CLI, this project also provides an app which enables the management of auditing rules and allows interpretation of tracked audit events.

![Image of the App showing network activity tracked by auditd](doc/img/auditd_app_network.png?raw=true "tracked network activity by auditd")

# License
This project is licensed under the GNU GENERAL PUBLIC LICENSE

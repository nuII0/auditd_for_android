# auditd_for_android
This project aims to make the audit subsystem of the Linux Kernel usable for Android 6+.
It does so by porting auditd and its userland tools to Android by forking and making Android-NDK projects out of them.

Since the administration of auditd is usually only possible via the CLI, this project also provides an system-tools and an app which enables the management of auditing rules and allows interpretation of tracked audit events.
![Image of the App showing network activity tracked by auditd](doc/img/auditd_app_network.png?raw=true "tracked network activity by auditd")

With `auditd` under Android it is possible to track all syscalls of the system. The image above demonstrates how the App is able to track network-acitivty of the system.

## Architecture
The picture below gives an overview of the architecture.

![Project architecture](doc/img/all_arch_en.png?raw=true "tracked network activity by auditd")

The tools `auditctl` `ausearch` and `auditd` are tools from the official auditd-Project. `forensikmediator` and `audit-dispatch` are added utilities to make auditd usable under Android.

The current state of the project loggs auditd-events in an persistent textfile located at `/storage/audit_stream.txt`. This approach is highly unusable for production when the textfile is growing quickly. A better solution would be a persistent database (SQLite).

## Usage

The project is structured in several Android-NDK projects and can be build as such via the `ndk-build` binary which comes with the official Android-NDK.
The app `AndroidForensik` is a Android-SDK project and can be build with the official Android-SDK. All projects can be managed from `Android-Studio`.

### Build instructions

All components provide a `Android.mk` makefile which can be build via the included `build.sh`-scripts or alternatively, inside the `Android-Studio` IDE.

### Installation
For testing purposes, it is sufficent to just copy the binaries over via adb to an running Android system and simply run them via `./auditd`, `./forensikmediator` and `./audit-dispatch`. 

#### Persistent installation
In order to run the builded binaries on an Android system in a persistet way, they needed to be installed under `/system/bin/` and declared as system services in init.rc. There are many ways to install persistent files on Android, either by building a custom image from source or modifiying existing ROM-Images and modifying `system.img` and `ramdisk.img`.

##### Init.rc system services
To declare the required components as system services, modify Androids `init.rc` with the follow entries
```
service auditd /system/bin/auditd -n
class core
critical
socket audit stream 660 system system

service audit-dispatch /system/bin/audit-dispatch
class core
critical

service forensikmediator /system/bin/forensikmediator
class core
critical
```

##### SELinux rules
Further, it is required to add SELinux rules to make `auditd` and friends operable. The following rules needs to be added:
```
#============= init ==============
allow init kernel:system module_request;
allow init self:netlink_audit_socket create;
allow init socket_device:sock_file { create setattr };
allow init auditd:file { execute execute_no_trans };
allow init audit-dispatch:file { execute execute_no_trans };
allow init forensikmediator:file { execute execute_no_trans };
#============= auditd ==============
allow auditd self:socket { create read write setattr };
allow audit-dispatch self:file { create read write };
#============= audit-dispatch ==============
allow audit-dispatch self:file { create read write setattr };
#============= forensikmediator ==============
allow forensikmediator self:file { create read write setattr };
allow forensikmediator self:socket { create read write setattr };
```

# License
This project is licensed under the GNU General Public License v3.0.

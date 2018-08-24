/* This is a generated file, see Makefile.am for its inputs. */
static const char normalize_record_map_strings[] = "aborted-auditd-startup\0access-error\0access-permission\0access-result\0accessed-mac-policy-controlled-object\0accessed-policy-controlled-file\0acquired-credentials\0added-group-account-to\0added-user-account\0assigned-user-role-to\0"
	"assigned-vm-id\0assigned-vm-resource\0attempted-execution-of-forbidden-program\0attempted-log-in-during-unusual-hour-to\0attempted-log-in-from-unusual-place-to\0audit-error\0authenticated\0authenticated-to-group\0booted-system\0called-seccomp-controlled-syscall\0"
	"caused-account-error\0changed-audit-configuration\0changed-audit-feature\0changed-auditd-configuration\0changed-configuration\0changed-group\0changed-group-password\0changed-login-id-to\0changed-mac-configuration\0changed-password\0"
	"changed-role-to\0changed-selinux-boolean\0changed-selinux-enforcement-to\0changed-to-runlevel\0changed-user-id\0checked-integrity-of\0configured-device\0crashed-program\0created-vm-image\0crypto-officer-logged-in\0"
	"crypto-officer-logged-out\0deleted-group-account-from\0deleted-user-account\0deleted-vm-image\0disposed-credentials\0ended-session\0failed-log-in-too-many-times-to\0initialized-audit-subsystem\0issued-vm-control\0loaded-kernel-module\0"
	"loaded-mac-policy\0loaded-selinux-policy\0locked-account\0logged-in\0logged-out\0mac-permission\0migrated-vm-from\0migrated-vm-to\0modified-group-account\0modified-level-of\0"
	"modified-role\0modified-user-account\0negotiated-crypto-key\0opened-too-many-sessions-to\0overrode-label-of\0ran-command\0reconfigured-auditd\0refreshed-credentials\0relabeled-filesystem\0remote-audit-connected\0"
	"remote-audit-disconnected\0removed-use-role-from\0resumed-audit-logging\0rotated-audit-logs\0sent-message\0sent-test\0shutdown-audit\0shutdown-system\0started-audit\0started-crypto-session\0"
	"started-service\0started-session\0stopped-service\0tested-file-system-integrity-of\0typed\0typed\0unknown\0unlocked-account\0used-suspcious-link\0was-authorized";
static const int normalize_record_map_i2s_i[] = {
	1005,1006,1100,1101,1102,1103,1104,1105,1106,1107,
	1108,1109,1110,1111,1112,1113,1114,1115,1116,1117,
	1118,1119,1120,1121,1122,1123,1124,1125,1126,1127,
	1128,1129,1130,1131,1132,1133,1134,1135,1136,1137,
	1200,1201,1202,1203,1204,1205,1206,1207,1208,1209,
	1305,1319,1326,1328,1330,1331,1400,1403,1404,1405,
	1701,1702,2000,2100,2101,2102,2104,2109,2112,2300,
	2301,2302,2303,2304,2309,2310,2311,2312,2402,2403,
	2404,2407,2500,2501,2502,2503,2504,2505,2506,2507,
};
static const unsigned normalize_record_map_i2s_s[] = {
	1582,635,391,1810,1305,138,993,1689,1014,36,
	681,476,1427,576,1182,1192,182,955,159,928,
	54,598,1595,1765,23,1395,1753,789,405,428,
	1620,769,1673,1705,1250,612,1203,1167,1773,826,
	1636,1605,0,547,1407,1563,1541,1470,1493,379,
	497,1759,442,525,1106,106,68,1145,738,714,
	844,1790,1060,1028,300,1349,340,1721,259,698,
	201,1519,1377,1273,1449,1127,1291,655,877,902,
	1327,1650,1088,238,223,805,860,976,1218,1235,
};
static const char *normalize_record_map_i2s(int v) {
	return i2s_bsearch__(normalize_record_map_strings, normalize_record_map_i2s_i, normalize_record_map_i2s_s, 90, v);
}

/* This is a generated file, see Makefile.am for its inputs. */
static const char normalize_obj_kind_map_strings[] = "account\0admin-defined-rule\0audit-config\0block-device\0character-device\0device\0directory\0fifo\0file\0file-system\0"
	"firewall\0keystrokes\0mac-config\0memory\0printer\0process\0service\0socket\0symlink\0system\0"
	"unknown\0user-session\0virtual-machine";
static const unsigned normalize_obj_kind_map_i2s_direct[] = {
	193,87,53,77,40,92,178,171,155,109,
	163,0,201,214,147,186,8,27,129,97,
	140,118,70,
};
static const char *normalize_obj_kind_map_i2s(int v) {
	return i2s_direct__(normalize_obj_kind_map_strings, normalize_obj_kind_map_i2s_direct, 0, 22, v);
}

/* private.h -- 
 * Copyright 2005,2006,2009 Red Hat Inc., Durham, North Carolina.
 * All Rights Reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 * Authors:
 *	Steve Grubb <sgrubb@redhat.com>
 */
#ifndef _PRIVATE_H_
#define _PRIVATE_H_

#ifdef __cplusplus
extern "C" {
#endif

#ifdef PIC
# define hidden __attribute__ ((visibility ("hidden")))
# define hidden_proto(fct) __hidden_proto (fct, fct##_internal)
# define __hidden_proto(fct, internal)  \
     extern __typeof (fct) internal;    \
     extern __typeof (fct) fct __asm (#internal) hidden;
# if defined(__alpha__) || defined(__mips__)
#  define hidden_def(fct) \
     asm (".globl " #fct "\n" #fct " = " #fct "_internal");
# else
#  define hidden_def(fct) \
     asm (".globl " #fct "\n.set " #fct ", " #fct "_internal");
#endif
#else
# define hidden
# define hidden_proto(fct)
# define hidden_def(fct)
#endif

typedef enum { REAL_ERR, HIDE_IT } hide_t;

/* Internal syslog messaging */
void audit_msg(int message_type, const char *fmt, ...) 
#ifdef __GNUC__
	__attribute__ ((format (printf, 2, 3)));
#else
	;
#endif

/* This structure is for protocol reference only.  All fields are
   packed and in network order (LSB first).  */
struct auditd_remote_message_wrapper {
	/* The magic number shall never have LF (0x0a) as one of its bytes.  */
	uint32_t	magic;
	/* Bumped when the layout of this structure changes.  */
	uint8_t		header_version;
	/* The minimum support needed to understand this message type.
	 * Normally zero.  */
	uint8_t		message_version;
	/* Upper 8 bits are generic type, see below.  */
	uint32_t	type;
	/* Number of bytes that follow this header  Must be 0..MAX_AUDIT_MESSAGE_LENGTH.  */
	uint16_t	length;
	/* Copied from message to its reply. */
	uint32_t	sequence_id;
	/* The message follows for LENGTH bytes.  */
};

#define AUDIT_RMW_HEADER_SIZE		16
/* The magic number shall never have LF (0x0a) as one of its bytes.  */
#define AUDIT_RMW_MAGIC			0xff0000feUL

#define AUDIT_RMW_HEADER_VERSION	0

/* If set, this is a reply.  */
#define AUDIT_RMW_TYPE_REPLYMASK	0x40000000
/* If set, this reply indicates a fatal error of some sort.  */
#define AUDIT_RMW_TYPE_FATALMASK	0x20000000
/* If set, this reply indicates success but with some warnings.  */
#define AUDIT_RMW_TYPE_WARNMASK		0x10000000
/* This part of the message type is the details for the above.  */
#define AUDIT_RMW_TYPE_DETAILMASK	0x0fffffff

/* Version 0 messages.  */
#define AUDIT_RMW_TYPE_MESSAGE		0x00000000
#define AUDIT_RMW_TYPE_HEARTBEAT	0x00000001
#define AUDIT_RMW_TYPE_ACK		0x40000000
#define AUDIT_RMW_TYPE_ENDING		0x40000001
#define AUDIT_RMW_TYPE_DISKLOW		0x50000001
#define AUDIT_RMW_TYPE_DISKFULL		0x60000001
#define AUDIT_RMW_TYPE_DISKERROR	0x60000002

/* These next four should not be called directly.  */
#define _AUDIT_RMW_PUTN32(header,i,v)	\
	header[i] = v & 0xff;		\
	header[i+1] = (v>>8) & 0xff;	\
	header[i+2] = (v>>16) & 0xff;	\
	header[i+3] = (v>>24) & 0xff;
#define _AUDIT_RMW_PUTN16(header,i,v)			\
	header[i] = v & 0xff;		\
	header[i+1] = (v>>8) & 0xff;
#define _AUDIT_RMW_GETN32(header,i)			\
	(((uint32_t)(header[i] & 0xFF)) |               \
	 (((uint32_t)(header[i+1] & 0xFF))<<8) |        \
	 (((uint32_t)(header[i+2] & 0xFF ))<<16) |      \
	 (((uint32_t)(header[i+3] & 0xFF))<<24))
#define _AUDIT_RMW_GETN16(header,i)			\
	((uint32_t)(header[i] & 0xFF) | ((uint32_t)(header[i+1] & 0xFF)<<8))

/* For these, HEADER must by of type "unsigned char *" or "unsigned
   char []" */

#define AUDIT_RMW_PACK_HEADER(header,mver,type,len,seq) \
	_AUDIT_RMW_PUTN32 (header,0, AUDIT_RMW_MAGIC); \
	header[4] = AUDIT_RMW_HEADER_VERSION;  \
	header[5] = mver;  \
	_AUDIT_RMW_PUTN32 (header,6, type);  \
	_AUDIT_RMW_PUTN16 (header,10, len); \
	_AUDIT_RMW_PUTN32 (header,12, seq);

#define AUDIT_RMW_IS_MAGIC(header,length)		\
	(length >= 4 && _AUDIT_RMW_GETN32 (header,0) == AUDIT_RMW_MAGIC)

#define AUDIT_RMW_UNPACK_HEADER(header,hver,mver,type,len,seq) \
	hver = header[4]; \
	mver = header[5]; \
	type = _AUDIT_RMW_GETN32 (header,6); \
	len = _AUDIT_RMW_GETN16 (header,10); \
	seq = _AUDIT_RMW_GETN32 (header,12);

/* General */
extern int audit_send(int fd, int type, const void *data, unsigned int size);

// This is the main messaging function used internally
// Don't hide it, it used to be a part of the public API!
extern int audit_send_user_message(int fd, int type, hide_t hide_err, 
	const char *message);

// libaudit.c
extern int _audit_permadded;
extern int _audit_archadded;
extern int _audit_syscalladded;
extern unsigned int _audit_elf;

hidden_proto(audit_send_user_message);
hidden_proto(audit_add_watch_dir);
hidden_proto(audit_detect_machine);
hidden_proto(audit_request_status);
hidden_proto(audit_rule_syscall_data);
hidden_proto(audit_rule_syscallbyname_data);

// lookup_table.c
hidden_proto(audit_elf_to_machine);
hidden_proto(audit_machine_to_elf);
hidden_proto(audit_msg_type_to_name);
hidden_proto(audit_name_to_errno);
hidden_proto(audit_name_to_field);
hidden_proto(audit_name_to_machine);
hidden_proto(audit_name_to_msg_type);
hidden_proto(audit_name_to_syscall);
hidden_proto(audit_operator_to_symbol);
hidden_proto(audit_name_to_ftype);

// netlink.c
hidden_proto(audit_get_reply);
hidden_proto(audit_send)

// message.c
hidden_proto(audit_msg)

// strsplit.c
char *audit_strsplit_r(char *s, char **savedpp);
char *audit_strsplit(char *s);


#ifdef __cplusplus
}
#endif

#endif


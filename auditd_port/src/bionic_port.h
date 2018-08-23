#ifndef BIONIC_PORT_H
#define BIONIC_PORT_H
// Funktionen wie fd_set sind in bionic unter
// <sys/select.h> anstatt in <select.h>
// zu finden
#include <sys/select.h>

// Android bionic besitzt die Funktion fgets_unlocked nicht,
// daher wird diese hier definiert.
#ifdef ANDROID
#define fgets_unlocked(buf, size, fp) fgets(buf, size, fp)
#endif

#ifndef strndupa
# include <alloca.h>
# include <string.h>
# define strndupa(s, n)							\
    ({											\
      const char *__old = (s);					\
      size_t __len = strnlen(__old, (n));       \
      char *__new = (char *) alloca(__len + 1); \
      __new[__len] = '\0';                      \
      (char *) memcpy(__new, __old, __len);     \
    })
#endif

/* fflush_unlocked ist ebenfalls nicht in
 * bionic verfügbar. Daher wird ein Alias
 * auf fflush() erstellt. */
# if HAVE_DECL_FFLUSH_UNLOCKED
#  undef fflush
#  define fflush(x) fflush_unlocked (x)
# else
#  define fflush_unlocked(x) fflush (x)
# endif

/* endprotoend() wird nicht unterstützt von bionic
 * und muss mit einem Dummy ersetzt werden */
void endprotoent(void);

/* Die Implementation von rawmemchr()
 * wurde aus der glibc kopiert */
void *rawmemchr (const void *s, int c_in);
#endif

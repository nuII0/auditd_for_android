/* This is a generated file, see Makefile.am for its inputs. */
static const char ip6optname_strings[] = "IP6T_SO_GET_REVISION_MATCH\0IP6T_SO_GET_REVISION_TARGET\0IP6T_SO_ORIGINAL_DST\0IP6T_SO_SET_ADD_COUNTERS\0IP6T_SO_SET_REPLACE\0IPV6_2292DSTOPTS\0IPV6_2292HOPLIMIT\0IPV6_2292HOPOPTS\0IPV6_2292PKTINFO\0IPV6_2292PKTOPTIONS\0"
	"IPV6_2292RTHDR\0IPV6_ADDRFORM\0IPV6_ADDR_PREFERENCES\0IPV6_ADD_MEMBERSHIP\0IPV6_AUTHHDR\0IPV6_AUTOFLOWLABEL\0IPV6_CHECKSUM\0IPV6_DONTFRAG\0IPV6_DROP_MEMBERSHIP\0IPV6_DSTOPTS\0"
	"IPV6_FLOWINFO\0IPV6_FLOWINFO_SEND\0IPV6_FLOWLABEL_MGR\0IPV6_HDRINCL\0IPV6_HOPLIMIT\0IPV6_HOPOPTS\0IPV6_IPSEC_POLICY\0IPV6_JOIN_ANYCAST\0IPV6_LEAVE_ANYCAST\0IPV6_MINHOPCOUNT\0"
	"IPV6_MTU\0IPV6_MTU_DISCOVER\0IPV6_MULTICAST_HOPS\0IPV6_MULTICAST_IF\0IPV6_MULTICAST_LOOP\0IPV6_NEXTHOP\0IPV6_ORIGDSTADDR\0IPV6_PATHMTU\0IPV6_PKTINFO\0IPV6_RECVDSTOPTS\0"
	"IPV6_RECVERR\0IPV6_RECVFRAGSIZE\0IPV6_RECVHOPLIMIT\0IPV6_RECVHOPOPTS\0IPV6_RECVPATHMTU\0IPV6_RECVPKTINFO\0IPV6_RECVRTHDR\0IPV6_RECVTCLASS\0IPV6_ROUTER_ALERT\0IPV6_RTHDR\0"
	"IPV6_RTHDRDSTOPTS\0IPV6_TCLASS\0IPV6_TRANSPARENT\0IPV6_UNICAST_HOPS\0IPV6_UNICAST_IF\0IPV6_USE_MIN_MTU\0IPV6_V6ONLY\0IPV6_XFRM_POLICY\0MCAST_BLOCK_SOURCE\0MCAST_JOIN_GROUP\0"
	"MCAST_JOIN_SOURCE_GROUP\0MCAST_LEAVE_GROUP\0MCAST_LEAVE_SOURCE_GROUP\0MCAST_MSFILTER\0MCAST_UNBLOCK_SOURCE";
static const unsigned ip6optname_i2s_direct[] = {
	225,173,156,121,210,190,313,138,624,281,
	375,-1u,-1u,-1u,-1u,904,586,566,604,261,
	341,828,548,539,697,955,485,503,-1u,-1u,
	-1u,408,389,467,967,427,-1u,-1u,-1u,-1u,
	-1u,1003,984,1102,1044,1020,1062,1087,780,667,
	728,440,746,454,857,797,846,680,362,763,
	654,327,938,101,76,812,875,0,27,294,
	-1u,239,522,637,887,922,710,-1u,-1u,55,
};
static const char *ip6optname_i2s(int v) {
	return i2s_direct__(ip6optname_strings, ip6optname_i2s_direct, 1, 80, v);
}
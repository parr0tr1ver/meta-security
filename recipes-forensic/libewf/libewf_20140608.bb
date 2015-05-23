SUMMARY = "library with support for Expert Witness Compression Format"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=58c39b26c0549f8e1bb4122173f474cd"

DEPENDS = "virtual/gettext libtool"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/libe/${BPN}/${BPN}_${PV}.orig.tar.gz;name=orig \
        file://gcc5_fix.patch \
        "
SRC_URI[orig.md5sum] = "3791d6de5910a0f6b4427cdf1e6bc663"
SRC_URI[orig.sha256sum] = "e0f14071665b24a8077a24f4cafbf092ad5ac1859f49994dc4e843e747ba7a89"

inherit autotools-brokensep pkgconfig

PACKAGECONFIG ??= "zlib ssl bz2"
PACKAGECONFIG[zlib] = "--with-zlib, --without-zlib, zlib, zlib"
PACKAGECONFIG[bz2] = "--with-bzip2, --without-bzip2, bzip2, bzip2"
PACKAGECONFIG[ssl] = "--with-openssl, --without-openssl, openssl, openssl"
PACKAGECONFIG[fuse] = "--with-libfuse, --without-libfuse, fuse"
PACKAGECONFIG[python] = "--enable-python, --disable-python, python"

EXTRA_OECONF += "--with-gnu-ld --disable-rpath"

RDEPENDS_${PN} += " util-linux-libuuid"
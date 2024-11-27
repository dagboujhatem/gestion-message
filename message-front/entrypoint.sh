#!/bin/sh
chown -R webadm:webadm /var/run/nginx
exec "$@"

#!/bin/sh
# Change ownership of the nginx runtime directory
chown -R webadm:webadm /var/run/nginx
# Use envsubst to substitute environment variables in the template
envsubst < /usr/share/nginx/html/assets/env.template.js > /usr/share/nginx/html/assets/env.js
exec "$@"

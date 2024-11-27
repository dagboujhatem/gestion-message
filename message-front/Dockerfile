# Stage 1: Build the Angular application
FROM node:18 as build-stage

# Set working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json for dependency installation
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the entire Angular project to the container
COPY . .

# Build the Angular application for production
RUN npm run build --prod

# Stage 2: Serve the Angular application with NGINX
FROM nginx:alpine as production-stage

# Create a non-root user `webadm` for running the application
RUN addgroup -g 1001 webadm && \
    adduser -G webadm -u 1001 -D -s /bin/sh webadm

# Set working directory inside the container
WORKDIR /usr/share/nginx/html

# Remove the default NGINX static assets
RUN rm -rf ./*

# Copy Angular build artifacts from Stage 1
COPY --from=build-stage /app/dist/message-front ./

# Copy custom NGINX configuration (if needed)
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Create necessary cache directories and set permissions for webadm
RUN mkdir -p /var/cache/nginx/client_temp && \
    chown -R webadm:webadm /var/cache/nginx


# Change ownership of the files to `webadm`
RUN chown -R webadm:webadm /usr/share/nginx/html

COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Switch to the `webadm` user
# Fix it Later using webadm user
USER root

# Expose the default NGINX port
EXPOSE 80

## Start NGINX
ENTRYPOINT ["/entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]

# Use official Nginx image
FROM nginx:alpine

# Remove default static content
RUN rm -rf /usr/share/nginx/html/*

# Copy our HTML into Nginx
COPY html/ /usr/share/nginx/html/

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]

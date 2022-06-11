---
# Feel free to add content and custom Front Matter to this file.
# To modify the layout, see https://jekyllrb.com/docs/themes/#overriding-theme-defaults

layout: default
---

{% include navigation.md %}

Below are instructions for deploying this application on either a self hosted solution, or a cloud VPS.

**Requirements**: A GNU/Linux Distro, in this guide I will be using Ubuntu 20.04 on DigitalOcean.

1. Clone the current repository onto the remote machine with `git clone https://github.com/rpeddakama/Tri-2-CSA-Project/`
2. Install Java: `sudo apt-get update && sudo apt-get -y install default-jdk`, verify installation with `java -version`
3. Install Maven: `sudo apt-get update && sudo apt-get -y install maven`, verify installation with `mvn -version`
4. Install Nginx: `sudo apt-get update && sudo apt-get -y install nginx`, verify installation by viewing `/etc/nginx/`
5. Build the SpringBoot Application using `mvn package`, the .jar file will be generated in the `target/` directory
6. Run the jar file in the background using `nohup java -jar <your_app_name>-<your_app_version>.jar > log.txt 2>&1 &`
7. Create a new Nginx site config to reverse proxy `localhost:8080` to port `80`.
8. Restart Nginx, and verify the site is working by visiting: `<VPS Public IP>:80`

### Nginx Config:

```
server {
    server_name www.dnhsnest.tk;
    return 301 https://dnhsnest.tk$request_uri;


    listen 443 ssl; # managed by Certbot
    ssl_certificate /etc/letsencrypt/live/www.dnhsnest.tk/fullchain.pem; # managed by Certbot
    ssl_certificate_key /etc/letsencrypt/live/www.dnhsnest.tk/privkey.pem; # managed by Certbot
    include /etc/letsencrypt/options-ssl-nginx.conf; # managed by Certbot
    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem; # managed by Certbot

}

server {

	server_name dnhsnest.tk;

	location / {
		proxy_pass http://127.0.0.1:8080;
	}

    listen [::]:443 ssl ipv6only=on; # managed by Certbot
    listen 443 ssl; # managed by Certbot
    ssl_certificate /etc/letsencrypt/live/dnhsnest.tk/fullchain.pem; # managed by Certbot
    ssl_certificate_key /etc/letsencrypt/live/dnhsnest.tk/privkey.pem; # managed by Certbot
    include /etc/letsencrypt/options-ssl-nginx.conf; # managed by Certbot
    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem; # managed by Certbot

}
server {
    if ($host = dnhsnest.tk) {
        return 301 https://$host$request_uri;
    } # managed by Certbot


	listen 80 default_server;
	listen [::]:80 default_server;

	server_name dnhsnest.tk www.dnhsnest.tk;
    return 404; # managed by Certbot


}
server {
    if ($host = www.dnhsnest.tk) {
        return 301 https://$host$request_uri;
    } # managed by Certbot


    server_name www.dnhsnest.tk;
    listen 80;
    return 404; # managed by Certbot


}
```

### Service File:

```
[Unit]
Description=DNHS Nest
After=network.target
StartLimitIntervalSec=0

[Service]
Type=simple
Restart=always
RestartSec=1
User=ubuntu
ExecStart=java -cp /home/ubuntu/Tri-2-CSA-Project/target/serving-web-content-0.0.1-SNAPSHOT.jar com.example.sping_portfolio.Main

[Install]
WantedBy=multi-user.target
```

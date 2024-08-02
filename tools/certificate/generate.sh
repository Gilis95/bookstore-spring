openssl ecparam -name sect571k1 -genkey -noout -out key.pem
openssl req -key key.pem -new -out certificate_request.csr
openssl req -new -nodes -sha256 -out certificate_request.csr -subj "/CN=example.com/O=MyOrganization/OU=MyUnit/C=US/ST=AR/L=Fayetteville"
openssl x509 -signkey key.pem -in certificate_request.csr -req -days 666 -out certificate.crt
openssl pkcs12 -inkey key.pem -in certificate.crt -export -out certificate.p12

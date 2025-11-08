# Configuracion para postman:
const var_token = pm.response.json().token

pm.globals.set("auth_jwt", var_token);



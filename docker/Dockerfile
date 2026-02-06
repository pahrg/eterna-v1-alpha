FROM tomcat:10-jre21
LABEL maintainer="admin@keep.pt" vendor="KEEP SOLUTIONS"

RUN set -ex; \
    apt-get -qq update && \
    apt-get -qq -y install --no-install-recommends \
    software-properties-common \
    python3-pip \
    python3-venv \
    clamdscan \
    zip \
    unzip \
    rsync \
    jq \
    curl; \
    pip install --no-cache-dir --break-system-packages unoserver==3.1; \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# 2. Setup ClamAV configuration
COPY ./docker-files/clamd.conf /etc/clamav/clamd.conf

# 3. Clean Tomcat and Install Web Application
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY ./target/  /usr/local/tomcat/webapps/ROOT

# 4. Prepare Tomcat Permissions
RUN mkdir -p /usr/local/tomcat/conf/Catalina/localhost && \
    chmod -R a+rwx /usr/local/tomcat/conf/Catalina

# 5. Inject RODA Configurations into the JAR
# This combined step configures ClamAV, Siegfried, and your new Unoserver settings
RUN set -ex; \
    JAR_FILE=$(ls /usr/local/tomcat/webapps/ROOT/WEB-INF/lib/roda-core-*.jar | head -n 1); \
    unzip -q "$JAR_FILE" config/roda-core.properties && \
    # Comment out existing/conflicting settings
    sed -i -e 's/^core.plugins.internal.virus_check.clamav/#&/' \
           -e 's/^core.tools.siegfried.mode/#&/' \
           -e 's/^core.tools.gotenberg/#&/' config/roda-core.properties && \
    # Append new configurations
    { \
        echo ""; \
        echo "# Virus Check Config"; \
        echo "core.plugins.internal.virus_check.clamav.bin = /usr/bin/clamdscan"; \
        echo "core.plugins.internal.virus_check.clamav.params = -m --fdpass"; \
        echo "core.plugins.internal.virus_check.clamav.get_version = clamdscan --version"; \
        echo ""; \
        echo "# Identifier Config"; \
        echo "core.tools.siegfried.mode = server"; \
        echo ""; \
        echo "# Unoserver (Office Conversion) Config"; \
        echo "core.tools.unoserver.bin = /usr/local/bin/unoconvert"; \
        echo "core.tools.unoserver.params = --host unoserver --port 2003"; \
    } >> config/roda-core.properties && \
    # Re-pack the properties into the JAR and clean up
    zip -q "$JAR_FILE" config/roda-core.properties && \
    rm config/roda-core.properties

# 6. Environment Variables
ENV RODA_HOME=/roda \
    SIEGFRIED_MODE=server \
    SIEGFRIED_SERVER_URL=http://siegfried:5138 \
    RODA_USER="roda" \
    RODA_UID="1000" \
    RODA_GROUP="roda" \
    RODA_GID="1000"

# 7. Setup Entrypoint and User Permissions
COPY ./docker-files/docker-entrypoint.sh /
COPY ./docker-files/docker-entrypoint.d/* /docker-entrypoint.d/

RUN set -ex; \
    # Check if user exists before modifying, otherwise create
    if id "ubuntu" >/dev/null 2>&1; then \
        usermod -l roda ubuntu && groupmod -n roda ubuntu; \
    else \
        groupadd -g "$RODA_GID" roda && \
        useradd -u "$RODA_UID" -g roda -m roda; \
    fi; \
    usermod -d /home/roda -m roda; \
    mkdir -p -m0770 "$RODA_HOME/data" "$RODA_HOME/config"; \
    chown -R "$RODA_USER:0" "$RODA_HOME"

VOLUME "$RODA_HOME/data"

USER "$RODA_UID"

ENTRYPOINT ["/docker-entrypoint.sh"]
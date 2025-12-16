# Standardkonfiguration för AIP-behörigheter

Det är möjligt att ändra hur AIP-behörigheter beviljas till användare och grupper när ett AIP skapas i webbgränssnittet
eller när det skapas via inmatning. För att göra detta måste följande konfigurationer ändras i filen roda-core.properties.

1. Om vi vill lägga till en grupp som supergrupp som har fullständiga behörigheter när AIP skapas, behöver vi helt enkelt lägga till
   följande rader:
   ```properties
    # Admin users or groups so AIPs can be administered
    
    core.aip.default_permissions.admin.group[] = administrators
    
    core.aip.default_permissions.admin.group[].administrators.permission[] = READ
    core.aip.default_permissions.admin.group[].administrators.permission[] = UPDATE
    core.aip.default_permissions.admin.group[].administrators.permission[] = CREATE
    core.aip.default_permissions.admin.group[].administrators.permission[] = GRANT
    core.aip.default_permissions.admin.group[].administrators.permission[] = DELETE
    ```

   Raderna ovan konfigurerar administrators-gruppen. Om vi ville lägga till en superanvändare, till exempel en admin-användare, skulle vi
   göra det så här:
    ```properties
    core.aip.default_permissions.admin.user[] = admin
   
    core.aip.default_permissions.admin.user[].admin.permission[] = READ
    core.aip.default_permissions.admin.user[].admin.permission[] = UPDATE
    core.aip.default_permissions.admin.user[].admin.permission[] = CREATE
    core.aip.default_permissions.admin.user[].admin.permission[] = GRANT
    core.aip.default_permissions.admin.user[].admin.permission[] = DELETE
    ```

   Om vi vill ställa in behörigheter för användaren som skapar AIP, gör vi det så här:
    ```properties
    # Direct creator permissions
    core.aip.default_permissions.creator.user.permission[] = CREATE
    core.aip.default_permissions.creator.user.permission[] = UPDATE
    core.aip.default_permissions.creator.user.permission[] = READ
    ```

   Om vi vill ställa in behörigheter för en specifik användare, lägg helt enkelt till följande (exempel på att ställa in behörigheter för
   användaren 'foo'):
    ```properties
    # Direct creator permissions
    core.aip.default_permissions.users[] = foo
    
    core.aip.default_permissions.users[].foo.permission[] = CREATE
    core.aip.default_permissions.users[].foo.permission[] = DELETE
    core.aip.default_permissions.users[].foo.permission[] = READ
    ```

   Slutligen kan vi också lägga till andra grupper, andra än supergrupper. Dessa är normala grupper och har inte fullständiga
   behörigheter.
    ```properties
    # Additional group permissions
    core.aip.default_permissions.group[] = archivists
    core.aip.default_permissions.group[] = producers
    core.aip.default_permissions.group[] = guests
    
    core.aip.default_permissions.group[].archivists.permission[] = READ
    core.aip.default_permissions.group[].archivists.permission[] = UPDATE
    core.aip.default_permissions.group[].archivists.permission[] = CREATE
    
    core.aip.default_permissions.group[].producers.permission[] = READ
    
    core.aip.default_permissions.group[].guests.permission[] = READ
    ```

2. Ett krav kan vara att användaren som skapade AIP måste tillhöra en av grupperna som definieras i
   konfigurationsfilen och har åtminstone READ och UPDATE-behörigheter. Om skärningspunkten är tom, eller generellt, om
   de inställda behörigheterna inte ger användaren åtminstone READ och UPDATE-behörigheter till det skapade AIP, så
   laddas dessa behörigheter som minimibehörigheter från konfigurationsfilen.
   ```properties
    # Intersect creator groups with the configuration groups
    core.aip.default_permissions.intersect_groups = true

    # System expects a minimum set of direct or indirect permissions for the creator (DO NOT CHANGE THIS!)
    core.aip.default_permissions.creator.minimum.permissions[] = UPDATE
    core.aip.default_permissions.creator.minimum.permissions[] = READ
    ```

   Som standard, och för att överensstämma med äldre beteende, beviljas skaparens användare alla behörigheter när ett AIP skapas. Om
   du inte vill använda äldre behörigheter, ställ in denna egenskap enligt följande:
    ```properties
    # Use legacy behaviour
    core.aip.default_permissions.legacy_permissions = false
    ```

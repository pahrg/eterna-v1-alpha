# Portal API User Administration

## Overview

This documentation describes the administration of the dedicated API user used for access to the external portal. This user is critical for system security and requires careful management of permissions.

## The Portal API User

The Portal API user is a special user account created specifically to give the external portal access to necessary resources via API. This account is already configured and has an assigned API key.

### Important characteristics:
- **Dedicated account**: Used only for portal integration
- **API key**: Unique key for authentication of API calls
- **Limited permissions**: Should only have necessary rights for portal functionality

## Permissions and Security Risks

### Recommended Permissions
- The Portal API user should not belong to groups
- Basic read permission for public documents
- No administrative access

### Specific Recommended Permissions

#### Intellectual entities (AIP)
- Retrieve intellectual entities (AIP)
- List and search intellectual entities (AIP)

#### Representations and Files
- List and search representations and computer files
- Retrieve representations and computer files

#### Descriptive Metadata
- List and retrieve descriptive metadata

### ⚠️ **Critical Security Risks**

Placing the Portal API user in groups with extended permissions poses serious security risks:

#### Permission Risks:
- **Data Exposure**: If the portal is compromised, sensitive archive documents may leak
- **Compliance Violations**: Breaches of data protection regulations (GDPR, etc.)

## Administration Guidelines

### Regular Checks
As administrator, you are responsible for regularly reviewing:
- The user's group membership
- Active permissions
- API key usage patterns
- Access logs

### Actions in Case of Suspected Compromise
1. **Immediate isolation**: Remove the user from all groups
2. **API key rotation**: Generate new key and update the portal
3. **Log review**: Investigate all activities during the recent period
4. **Incident reporting**: Document the event for future reference

### Best Practices
- **Principle of least privilege**: Grant only necessary rights
- **Regular review**: Monthly verification of permissions

## Contact and Support

For questions or need for permission changes, contact the system administrator or security officer before taking any actions.

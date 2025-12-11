# Disposal 

## Disposal Schedule

Please refer to [Disposal Policies](#theme/administration/Disposal_Policies.md) for more information about disposal schedules. 

### Configure ETERNA to show fields in retention trigger element identifier

The retention trigger element identifier is populated using the advanced search field items. From those fields the ones that have date_interval type will be selected and used in the calculation of retention period.  

## Disposal rule

Please refer to [Disposal Policies](#theme/administration/Disposal_Policies.md) for more information about disposal rules. 

### Configure ETERNA to show fields in selection method 'metadata field'

The metadata field is populated using the advanced search field items. From those fields the ones that have `text` type will be selected. ETERNA can be configured to ignore some of these fields. In order to do that, change your `roda-wui.properties` to add a new blacklist metadata. By default, ETERNA shows all `text` type descriptive metadata.

```javaproperties
ui.disposal.rule.blacklist.condition = description
```

Please refer to [Advanced Search](#theme/usage/Advanced_Search.md) for more information about add a new advanced search field item.

Please refer to [Metadata Formats](#theme/reference/Metadata_Formats.md) for more information about descriptive metadata configuration on ETERNA.

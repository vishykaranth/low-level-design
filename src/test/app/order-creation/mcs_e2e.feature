Feature: Merchant Configuration Service E2E

  Scenario: Validate that MCS can use WarrantyCreation configuration from MCS
    Given USE CASE #1: verify that all wcs config fields are applied to the warranty
    Given We have merchant configuration payload
    When We post the configuration as merchantAccount to MCS API
    Then We validate response status_code as 201 and response message with id
    When We approve a merchantAccount configuration for a real - new_approver subscription
    Then We validate response status_code as 204 and response message with no message
    When We get approved merchantAccount configuration
    Then We validate that merchant configuration is approved
    Then We compare the difference between input payload and output
    Given We have WCS configuration payload
    And We update the value.source in payload with BULK_WARRANTY value as string type
    And We update the value.forcePcs in payload with true value as bool type
    And We modify merchant.name for the wcs config to RESALE
    Then We delete all records with the given source in mcs db
    When We post the configuration as warrantyCreation to MCS API
    Then We validate response status_code as 201 and response message with id
    When We approve a warrantyCreation configuration for a real - new_approver subscription
    Then We validate response status_code as 204 and response message with no message
    When We get approved warrantyCreation configuration
    Then We validate that merchant configuration is approved
    Then We compare the difference between input payload and output
    Given We have a correct AAFES order payload with merchant.name from warrantyCreation configuration in MCS
    When We submit it to the warranty creation service
    Then It returns a reponse message with isWarranty=true but did not find valid product data on Product Catalog
    And We POST a product to PCS for the test merchant with primaryCategory as default
    Then We get the status code of 200
    And We release the catalog version for the posted products
    Then We get the status code of 200
    When We have a payload with the product rleased as a mock of AAFES
    And We submit it to the warranty creation service
    Then It returns a response message with SUCCESS
    And It returns either response message with a PERSON_CREATED or PERSON_EXISTS
    And We validate fake person's email for fake merchant
    And We validate that WCS config has taken effect on the warranty

    Given USE CASE #2: warrantyCreation configuration contains only the required "source" field
    Given We have merchant configuration payload
    When We post the configuration as merchantAccount to MCS API
    Then We validate response status_code as 201 and response message with id
    When We approve a merchantAccount configuration for a real - new_approver subscription
    Then We validate response status_code as 204 and response message with no message
    When We get approved merchantAccount configuration
    Then We validate that merchant configuration is approved
    Then We compare the difference between input payload and output
    Given We have WCS configuration payload
    And We remove the effective, value.merchantId, value.forcePcs, value.forcePop, value.defaultValues, value.derivationOverrideValues, value.overrideValues in payload with null value as null type
    When We post the configuration as warrantyCreation to MCS API
    Then We validate response status_code as 201 and response message with id
    When We approve a warrantyCreation configuration for a real - new_approver subscription
    Then We validate response status_code as 204 and response message with no message
    When We get approved warrantyCreation configuration
    Then We validate that merchant configuration is approved
    Then We compare the difference between input payload and output
    Given We have a correct AAFES order payload with merchant.name from warrantyCreation configuration in MCS
    When We submit it to the warranty creation service
    Then It returns a response message with isWarranty=true but did not find valid product data



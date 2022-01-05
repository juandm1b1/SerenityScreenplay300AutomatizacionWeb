@stories
Feature: Medical Appointment Management
  As a patient I want to request a medical appointment through the Hospitals Administration System

  @Scenario1:
    Scenario Outline: Register a doctor
      Given that Carlos needs to register a doctor
      When he makes the doctor registration on the Hospitals Administration System
        | strDoctorFName | strDoctorLName | strDoctorPhone | strDoctorDocType | strDoctorDocument |
        |<strDoctorFName>|<strDoctorLName>|<strDoctorPhone>|<strDoctorDocType>|<strDoctorDocument>|
      Then he verifies the successful doctor registration message
        |strDoctorMessage  |
        |<strDoctorMessage>|
      Examples:
        |strDoctorFName|strDoctorLName| strDoctorPhone   |strDoctorDocType     |strDoctorDocument|strDoctorMessage|
        | Martín       | Botero       |5707700           |Cédula de extrangería|10101066         |Datos guardados correctamente.|
        | Leidy        | Graciano     | 3004006969       |Pasaportes           |20202020         |No se pudo guardar debido a:|

  @Scenario2:
    Scenario Outline: Register a patient
      Given that Carlos needs to register a patient
      When he makes the patient registration on the Hospitals Administration System
        | strPatientFName  | strPatientLName  | strPatientPhone   | strPatientDocType   | strPatientDocument | boolPrepaid |
        | <strPatientFName>| <strPatientLName>|<strPatientPhone>  |<strPatientDocType>  |<strPatientDocument>|<boolPrepaid>|
      Then he verifies the successful patient registration message
        |strPatientMessage  |
        |<strPatientMessage>|
      Examples:
        |strPatientFName|strPatientLName| strPatientPhone|strPatientDocType   |strPatientDocument|boolPrepaid|strPatientMessage|
        | Juan David    | Botero        | 3223690000     |Cédula de ciudadanía|30303055          |true       |Datos guardados correctamente.|
        | Dante         | Aligieri      | 3194001111     |Pasaportes          |40404040          |false      |No se pudo guardar debido a:|

  @Scenario3:
    Scenario Outline: Request a medical appointment
      Given that Carlos needs to go to the doctor
      When he request a medical appointment
          | strAppointmentDate  | strPatientDoc  | strDoctorDoc   | strObservations   |
          | <strAppointmentDate>| <strPatientDoc>|<strDoctorDoc>  |<strObservations>  |
      Then he verifies the successful appointment request message
        |strAppointmentMessage  |
        |<strAppointmentMessage>|
      Examples:
        |strAppointmentDate|strPatientDoc|strDoctorDoc|strObservations |strAppointmentMessage|
        | 10/12/2022       | 30303044    |10101055    |Medicina general|Datos guardados correctamente.|
        | 10/07/2022       | 40404040    |20202099    |Ninguna         |No se pudo guardar debido a:|
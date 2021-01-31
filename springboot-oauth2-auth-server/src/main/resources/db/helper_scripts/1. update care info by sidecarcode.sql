
/*
Update specialties from care.
*/

UPDATE sidecarhealth_doctor_v2_db.care_rate  as rate 
JOIN sidecarhealth_care_db.care_reimbursement_info as care ON rate.sidecar_code = care.sidecar_code
SET rate.care_specialty = care.specialties
WHERE rate.id <> 0;
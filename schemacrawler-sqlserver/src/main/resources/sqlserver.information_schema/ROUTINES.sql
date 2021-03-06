SELECT
  ROUTINE_CATALOG,
  ROUTINE_SCHEMA,
  ROUTINE_NAME,
  SPECIFIC_NAME,
  ROUTINE_TYPE,
  ROUTINE_BODY,
  OBJECT_DEFINITION(OBJECT_ID(ROUTINE_CATALOG + '.' + ROUTINE_SCHEMA + '.' + ROUTINE_NAME))
    AS ROUTINE_DEFINITION,
  *
FROM
  INFORMATION_SCHEMA.ROUTINES

/* 
 *
 * SchemaCrawler
 * http://sourceforge.net/projects/schemacrawler
 * Copyright (c) 2000-2006, Sualeh Fatehi.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 */

package schemacrawler.schema;


import java.io.ObjectStreamException;

/**
 * View check options.
 */
public final class CheckOptionType
  implements EnumType
{

  private static final CheckOptionType NONE = new CheckOptionType("none");
  private static final CheckOptionType CASCADE = new CheckOptionType("cascade");

  private static final long serialVersionUID = 3546925783735220534L;

  private static final CheckOptionType[] ALL = {
      NONE, CASCADE,
  };

  private final int id;
  private final String name;

  private CheckOptionType(final String typeName)
  {
    ordinal = nextOrdinal++;
    id = ordinal;
    name = typeName;
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.schema.EnumType#getId()
   */
  public int getId()
  {
    return id;
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.schema.EnumType#getName()
   */
  public String getName()
  {
    return name;
  }

  /**
   * {@inheritDoc}
   * 
   * @see Object#toString()
   */
  public String toString()
  {
    return name;
  }

  /**
   * Find the enumeration value corresponding to the string.
   * 
   * @param typeString
   *        String value of table type
   * @return Enumeration value
   */
  public static CheckOptionType valueOf(final String typeString)
  {

    CheckOptionType checkOptionType = ALL[0];

    for (int i = 0; i < ALL.length; i++)
    {
      if (ALL[i].toString().equalsIgnoreCase(typeString))
      {
        checkOptionType = ALL[i];
        break;
      }
    }

    return checkOptionType;

  }

  // The 4 declarations below are necessary for serialization
  private static int nextOrdinal;
  private final int ordinal;

  private static final CheckOptionType[] VALUES = ALL;

  Object readResolve()
    throws ObjectStreamException
  {
    return VALUES[ordinal]; // Canonicalize
  }
}

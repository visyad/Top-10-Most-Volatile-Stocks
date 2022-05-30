# Top-10-Volatile-stocks-Using-Map-reduce
This project uses Mapreduce paradigm of Hadoop to serialize the
calculation of volatility for each month and computes the top 10 most
volatile and bottom 10 least volatile stock values.
- Number of Mapper Implementation : 3
- Number of Reducer Implementation : 3
# Roles of each Mapper and Reducer:
## Mapper1
- splits the input data and options the date and close adjacent value.
- key - stock_name + month + year
- value - date + adjacent close value
## Reducer1
- Since after the map step the values which have the same key are
grouped together and passed to the reducer as iterable, values that
correspond to specific month and year of the particular stock are
grouped together.
- Beginning adjacent close value and end adjacent close value are
obtained by integrating through the iterable and the value of xi for the
corresponding month is computed.
- Key - Company Name

## Mapper2
- Now we have to consolidate all the values obtained from the reducer
with respect to the company name.
- Key - Company Name
- Value - X i
## Reducer2
- All the xi corresponding to the the respective companies are grouped
together.
- Volatility for the particular company is obtained from these values.
- Key - Company Name
- Value - Volatility
## Mapper3:
- All the companies are grouped together with a common key.
- Key - Common
- Value = Company Name + Volatility
## Reducer3:
- Obtained iterable contains all the company name with values and
they are sorted by a custom comparator.
- Top 10 and bottom 10 values are obtained from the List

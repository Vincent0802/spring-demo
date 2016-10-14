package com.cyrus.demo.base.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * @Description: 实现分页查询
 *
 * @author Cloud
 *
 * @time: 2016年8月22日 下午4:30:05
 *
 */
public class DataSourceRequest {
	private int page;
	private int pageSize;
	private int take;
	private int skip;
	private List<SortDescriptor> sort;
	private List<GroupDescriptor> group;
	private List<AggregateDescriptor> aggregate;

	private FilterDescriptor filter;
	
	private Map<String , Object> filters;

	public DataSourceRequest() {
		filter = new FilterDescriptor();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTake() {
		return take;
	}

	public void setTake(int take) {
		this.take = take;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public List<SortDescriptor> getSort() {
		return sort;
	}

	public void setSort(List<SortDescriptor> sort) {
		this.sort = sort;
	}

	public FilterDescriptor getFilter() {
		return filter;
	}

	public void setFilter(FilterDescriptor filter) {
		this.filter = filter;
		flatFilter(filter);
	}
	
	private void flatFilter(FilterDescriptor filter){
		if(this.filters == null){
			this.filters = new HashMap<String, Object>();
		}
		if(filter != null){
			List<FilterDescriptor> filters = filter.getFilters();
			if(!filters.isEmpty()){
				//String logic = filter.getLogic().toString();
				for(FilterDescriptor entry : filters){
					if(!entry.getFilters().isEmpty()){
						flatFilter(filter);
					}else{
						this.filters.put(entry.getField(), entry.getValue());
					}
				}
			}
		}
	}

	private List<SortDescriptor> sortDescriptors() {
		List<SortDescriptor> sort = new ArrayList<SortDescriptor>();

		List<GroupDescriptor> groups = getGroup();
		List<SortDescriptor> sorts = getSort();

		if (groups != null) {
			sort.addAll(groups);
		}

		if (sorts != null) {
			sort.addAll(sorts);
		}
		return sort;
	}
	
	public void filter(SQL where , FilterDescriptor filter){
		if(filter != null){
			List<FilterDescriptor> filters = filter.filters;
			if(!filters.isEmpty()){
				String logic = filter.getLogic().toString();
				for(FilterDescriptor entry : filters){
					if(!entry.getFilters().isEmpty()){
						filter(where , filter);
					}else{
						String field = entry.getField();
				        Object value = entry.getValue();
				       //
						this.filters.put(field, value);
					}
				}
			}
		}
	}
	
	
	private void restrict(SQL where , FilterDescriptor filter){
		String operator = filter.getOperator();
        String field = filter.getField();
        Object value = filter.getValue();
        boolean ignoreCase = filter.isIgnoreCase();
        
        String[] nullables = {"isnull", "isnotnull", "isempty", "isnotempty"};
        
       /* if (!Arrays.asList(nullables).contains(operator)){
        	try {
                Class<?> type = new PropertyDescriptor(field, clazz).getPropertyType();
                if (type == double.class || type == Double.class) {
                    value = Double.parseDouble(value.toString());
                } else if (type == float.class || type == Float.class) {
                    value = Float.parseFloat(value.toString());
                } else if (type == long.class || type == Long.class) {
                    value = Long.parseLong(value.toString());
                } else if (type == int.class || type == Integer.class) {
                    value = Integer.parseInt(value.toString());
                } else if (type == short.class || type == Short.class) {
                    value = Short.parseShort(value.toString());
                } else if (type == boolean.class || type == Boolean.class) {
                    value = Boolean.parseBoolean(value.toString());
                } else if (type == Date.class){
                    SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" );
                    String input = value.toString();
                    value = df.parse(input);
                }   
            }catch (IntrospectionException e) {
            }catch (NumberFormatException nfe) {
            }catch (ParseException e) {
            }
        }
        switch(operator) {
        case "eq":
            if (value instanceof String) {
                junction.add(Restrictions.ilike(field, value.toString(), MatchMode.EXACT));
            } else {
                junction.add(Restrictions.eq(field, value));
            }
            break;
        case "neq":
            if (value instanceof String) {
                junction.add(Restrictions.not(Restrictions.ilike(field, value.toString(), MatchMode.EXACT)));
            } else {
                junction.add(Restrictions.ne(field, value));
            }
            break;
        case "gt":
            junction.add(Restrictions.gt(field, value));
            break;
        case "gte":
            junction.add(Restrictions.ge(field, value));
            break;
        case "lt":
            junction.add(Restrictions.lt(field, value));
            break;
        case "lte":
            junction.add(Restrictions.le(field, value));
            break;
        case "startswith":
            junction.add(getLikeExpression(field, value.toString(), MatchMode.START, ignoreCase));
            break;
        case "endswith":
            junction.add(getLikeExpression(field, value.toString(), MatchMode.END, ignoreCase));
            break;
        case "contains":
            junction.add(getLikeExpression(field, value.toString(), MatchMode.ANYWHERE, ignoreCase));
            break;
        case "doesnotcontain":
            junction.add(Restrictions.not(Restrictions.ilike(field, value.toString(), MatchMode.ANYWHERE)));
            break;
        case "isnull":
            junction.add(Restrictions.isNull(field));
            break;
        case "isnotnull":
            junction.add(Restrictions.isNotNull(field));
            break;
        case "isempty":
            junction.add(Restrictions.eq(field, ""));
            break;
        case "isnotempty":
            junction.add(Restrictions.not(Restrictions.eq(field, "")));                
            break;
    }*/
	}

	public List<GroupDescriptor> getGroup() {
		return group;
	}

	public void setGroup(List<GroupDescriptor> group) {
		this.group = group;
	}

	public List<AggregateDescriptor> getAggregate() {
		return aggregate;
	}

	public void setAggregate(List<AggregateDescriptor> aggregate) {
		this.aggregate = aggregate;
	}

	public static class SortDescriptor {
		private String field;
		private String dir;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getDir() {
			return dir;
		}

		public void setDir(String dir) {
			this.dir = dir;
		}
	}

	public static class GroupDescriptor extends SortDescriptor {
		private List<AggregateDescriptor> aggregates;

		public GroupDescriptor() {
			aggregates = new ArrayList<AggregateDescriptor>();
		}

		public List<AggregateDescriptor> getAggregates() {
			return aggregates;
		}
	}

	public static class AggregateDescriptor {
		private String field;
		private String aggregate;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getAggregate() {
			return aggregate;
		}

		public void setAggregate(String aggregate) {
			this.aggregate = aggregate;
		}
	}

	public static class FilterDescriptor {
		private String logic;
		private List<FilterDescriptor> filters;
		private String field;
		private Object value;
		private String operator;
		private boolean ignoreCase = true;

		public FilterDescriptor() {
			filters = new ArrayList<FilterDescriptor>();
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public String getLogic() {
			return logic;
		}

		public void setLogic(String logic) {
			this.logic = logic;
		}

		public boolean isIgnoreCase() {
			return ignoreCase;
		}

		public void setIgnoreCase(boolean ignoreCase) {
			this.ignoreCase = ignoreCase;
		}

		public List<FilterDescriptor> getFilters() {
			return filters;
		}
	}
}

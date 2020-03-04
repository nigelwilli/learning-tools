package dev.innov8.web;

public class HandlerContext {

	private String path;
	private String[] pathSegments;
	private int segIdx;
	private boolean done;
	private HttpMethod method;
	
	public HandlerContext(String path, HttpMethod method) {
		this.path = path;
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		pathSegments = path.split("/");
		segIdx = 0;
		done = false;
	}

	public String[] getPathSegments() {
		return pathSegments;
	}
	
	public String getPathSegment(boolean advance) {
		if(pathSegments == null || segIdx >= pathSegments.length) return null;
		String segment = pathSegments[segIdx];
		if (advance && segIdx <= pathSegments.length) segIdx++;
		return segment;
	}

	public String getCurrentPathSegment() {
		return getPathSegment(false);
	}
	
	public String getNextPathSegment() {
		return getPathSegment(true);
	}
	
	public String getPreviousPathSegment() {
		if(pathSegments == null) return null;
		if(segIdx - 1 < 0) return null;
		return pathSegments[segIdx - 1];
	}

	public void setPathSegments(String[] pathSegments) {
		this.pathSegments = pathSegments;
	}
	
	public int getSegIdx() {
		return segIdx;
	}

	public void setSegIdx(int segIdx) {
		this.segIdx = segIdx;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	
	
}

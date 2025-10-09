# sse_web_search
import httpx
from mcp.server import FastMCP

app = FastMCP('web-search', port=9001)

@app.tool()
async def web_search(query: str) -> str:
    """
     搜索互联网内容
     Args:
        query: 要搜索的内容
     Returns:
        搜索结果的总结
    """
    async with httpx.AsyncClient(timeout=20) as client:
        response = await client.post(
            'https://open.bigmodel.cn/api/paas/v4/tools',
            headers={
                'Authorization': '969ed6166ed84e008b382545b925c752.XY486jjVn6bO71uw',
                'Content-Type': 'application/json',
            },
            json={
                'tool': 'web-search-pro',
                'messages': [{'role': 'user', 'content': query}],
                'stream': False,
            },
        )
        if response.status_code != 200:
            return f'HTTP {response.status_code}: {response.text}'

        try:
            payload = response.json()
        except ValueError:
            return f'Invalid JSON response: {response.text}'

        # 兼容顶层或 data 包裹的 choices
        choices = payload.get('choices') or payload.get('data', {}).get('choices')
        if not choices:
            return f'API response missing choices: {payload}'

        res_data = []
        for choice in choices:
            message = choice.get('message') or {}
            tool_calls = message.get('tool_calls') or []
            for tc in tool_calls:
                search_results = tc.get('search_result') or []
                for result in search_results:
                    content = result.get('content') or result.get('snippet') or result.get('summary') or ''
                    if content:
                        res_data.append(content)

        return '\n\n\n'.join(res_data) if res_data else 'No search results found.'

if __name__ == '__main__':
    app.run(transport='sse')
